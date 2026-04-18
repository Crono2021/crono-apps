.class public Lorg/drinkless/tdlib/TdApi$InputCredentialsSaved;
.super Lorg/drinkless/tdlib/TdApi$InputCredentials;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputCredentialsSaved"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x794241d4


# instance fields
.field public savedCredentialsId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14604
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputCredentials;-><init>()V

    .line 14605
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 14595
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputCredentials;-><init>()V

    .line 14596
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputCredentialsSaved;->savedCredentialsId:Ljava/lang/String;

    .line 14597
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14601
    const v0, -0x794241d4

    return v0
.end method
