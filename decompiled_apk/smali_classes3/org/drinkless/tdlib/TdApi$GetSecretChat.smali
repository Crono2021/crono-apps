.class public Lorg/drinkless/tdlib/TdApi$GetSecretChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetSecretChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$SecretChat;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x26b7e81


# instance fields
.field public secretChatId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13578
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13579
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 13569
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13570
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetSecretChat;->secretChatId:I

    .line 13571
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13575
    const v0, 0x26b7e81

    return v0
.end method
