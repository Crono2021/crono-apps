.class public Lorg/drinkless/tdlib/TdApi$PassportElementDriverLicense;
.super Lorg/drinkless/tdlib/TdApi$PassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementDriverLicense"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x61f70cad


# instance fields
.field public driverLicense:Lorg/drinkless/tdlib/TdApi$IdentityDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17412
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17413
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$IdentityDocument;)V
    .locals 0
    .param p1, "identityDocument"    # Lorg/drinkless/tdlib/TdApi$IdentityDocument;

    .line 17403
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17404
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementDriverLicense;->driverLicense:Lorg/drinkless/tdlib/TdApi$IdentityDocument;

    .line 17405
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17409
    const v0, 0x61f70cad

    return v0
.end method
