.class public Lorg/drinkless/tdlib/TdApi$LoadDirectMessagesChatTopics;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LoadDirectMessagesChatTopics"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x58b215b7


# instance fields
.field public chatId:J

.field public limit:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28124
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 28125
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 28114
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 28115
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$LoadDirectMessagesChatTopics;->chatId:J

    .line 28116
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$LoadDirectMessagesChatTopics;->limit:I

    .line 28117
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28121
    const v0, 0x58b215b7

    return v0
.end method
