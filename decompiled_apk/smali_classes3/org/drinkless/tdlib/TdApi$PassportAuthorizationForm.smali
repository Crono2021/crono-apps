.class public Lorg/drinkless/tdlib/TdApi$PassportAuthorizationForm;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportAuthorizationForm"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3fd12d42


# instance fields
.field public id:I

.field public privacyPolicyUrl:Ljava/lang/String;

.field public requiredElements:[Lorg/drinkless/tdlib/TdApi$PassportRequiredElement;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38876
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38877
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$PassportRequiredElement;Ljava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "passportRequiredElementArr"    # [Lorg/drinkless/tdlib/TdApi$PassportRequiredElement;
    .param p3, "str"    # Ljava/lang/String;

    .line 38865
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38866
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$PassportAuthorizationForm;->id:I

    .line 38867
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PassportAuthorizationForm;->requiredElements:[Lorg/drinkless/tdlib/TdApi$PassportRequiredElement;

    .line 38868
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PassportAuthorizationForm;->privacyPolicyUrl:Ljava/lang/String;

    .line 38869
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38873
    const v0, -0x3fd12d42

    return v0
.end method
