.class public Lorg/drinkless/tdlib/TdApi$CreateSecretChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateSecretChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chat;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x730dd22f


# instance fields
.field public secretChatId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11130
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11131
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 11121
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11122
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$CreateSecretChat;->secretChatId:I

    .line 11123
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11127
    const v0, 0x730dd22f

    return v0
.end method
