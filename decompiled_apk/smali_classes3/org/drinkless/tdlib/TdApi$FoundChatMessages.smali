.class public Lorg/drinkless/tdlib/TdApi$FoundChatMessages;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FoundChatMessages"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x197ae424


# instance fields
.field public messages:[Lorg/drinkless/tdlib/TdApi$Message;

.field public nextFromMessageId:J

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37004
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37005
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$Message;J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "messageArr"    # [Lorg/drinkless/tdlib/TdApi$Message;
    .param p3, "j5"    # J

    .line 36993
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36994
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$FoundChatMessages;->totalCount:I

    .line 36995
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$FoundChatMessages;->messages:[Lorg/drinkless/tdlib/TdApi$Message;

    .line 36996
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$FoundChatMessages;->nextFromMessageId:J

    .line 36997
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37001
    const v0, 0x197ae424

    return v0
.end method
