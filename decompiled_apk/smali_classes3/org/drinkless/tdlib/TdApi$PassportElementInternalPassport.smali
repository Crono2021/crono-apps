.class public Lorg/drinkless/tdlib/TdApi$PassportElementInternalPassport;
.super Lorg/drinkless/tdlib/TdApi$PassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementInternalPassport"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x228ad87


# instance fields
.field public internalPassport:Lorg/drinkless/tdlib/TdApi$IdentityDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17520
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17521
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$IdentityDocument;)V
    .locals 0
    .param p1, "identityDocument"    # Lorg/drinkless/tdlib/TdApi$IdentityDocument;

    .line 17511
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17512
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementInternalPassport;->internalPassport:Lorg/drinkless/tdlib/TdApi$IdentityDocument;

    .line 17513
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17517
    const v0, 0x228ad87

    return v0
.end method
