.class public Lorg/drinkless/tdlib/TdApi$SetLoginEmailAddress;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetLoginEmailAddress"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x37bb43d4


# instance fields
.field public newLoginEmailAddress:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19788
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19789
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 19779
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19780
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetLoginEmailAddress;->newLoginEmailAddress:Ljava/lang/String;

    .line 19781
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19785
    const v0, 0x37bb43d4

    return v0
.end method
