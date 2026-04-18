.class public Lorg/drinkless/tdlib/TdApi$CheckAuthenticationEmailCode;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CheckAuthenticationEmailCode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x22bd3d61


# instance fields
.field public code:Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10518
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10519
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;)V
    .locals 0
    .param p1, "emailAddressAuthentication"    # Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;

    .line 10509
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10510
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CheckAuthenticationEmailCode;->code:Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;

    .line 10511
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10515
    const v0, -0x22bd3d61

    return v0
.end method
