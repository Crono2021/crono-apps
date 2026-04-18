.class public Lorg/drinkless/tdlib/TdApi$CloseSecretChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CloseSecretChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1c12fbb5


# instance fields
.field public secretChatId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10878
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10879
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 10869
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10870
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$CloseSecretChat;->secretChatId:I

    .line 10871
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10875
    const v0, -0x1c12fbb5

    return v0
.end method
