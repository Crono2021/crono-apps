.class public Lorg/drinkless/tdlib/TdApi$PassportElementPassport;
.super Lorg/drinkless/tdlib/TdApi$PassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementPassport"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xfbc18dd


# instance fields
.field public passport:Lorg/drinkless/tdlib/TdApi$IdentityDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17538
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17539
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$IdentityDocument;)V
    .locals 0
    .param p1, "identityDocument"    # Lorg/drinkless/tdlib/TdApi$IdentityDocument;

    .line 17529
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17530
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementPassport;->passport:Lorg/drinkless/tdlib/TdApi$IdentityDocument;

    .line 17531
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17535
    const v0, -0xfbc18dd

    return v0
.end method
