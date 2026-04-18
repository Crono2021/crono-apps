.class public Lorg/drinkless/tdlib/TdApi$UpdateTermsOfService;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateTermsOfService"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4dc33aa2


# instance fields
.field public termsOfService:Lorg/drinkless/tdlib/TdApi$TermsOfService;

.field public termsOfServiceId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35048
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35049
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$TermsOfService;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "termsOfService"    # Lorg/drinkless/tdlib/TdApi$TermsOfService;

    .line 35038
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35039
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateTermsOfService;->termsOfServiceId:Ljava/lang/String;

    .line 35040
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateTermsOfService;->termsOfService:Lorg/drinkless/tdlib/TdApi$TermsOfService;

    .line 35041
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35045
    const v0, -0x4dc33aa2

    return v0
.end method
