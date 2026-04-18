.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementIdentityCard;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementIdentityCard"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x98077e


# instance fields
.field public identityCard:Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15000
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15001
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;)V
    .locals 0
    .param p1, "inputIdentityDocument"    # Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;

    .line 14991
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 14992
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementIdentityCard;->identityCard:Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;

    .line 14993
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14997
    const v0, -0x98077e

    return v0
.end method
