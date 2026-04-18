.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeDirectMessagesChat;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeDirectMessagesChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6afdc830


# instance fields
.field public channelUsername:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15324
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15325
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15315
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15316
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeDirectMessagesChat;->channelUsername:Ljava/lang/String;

    .line 15317
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15321
    const v0, 0x6afdc830

    return v0
.end method
