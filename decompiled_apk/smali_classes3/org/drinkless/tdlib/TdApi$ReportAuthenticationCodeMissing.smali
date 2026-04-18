.class public Lorg/drinkless/tdlib/TdApi$ReportAuthenticationCodeMissing;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportAuthenticationCodeMissing"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6e1031b8


# instance fields
.field public mobileNetworkCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18762
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18763
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 18753
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18754
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReportAuthenticationCodeMissing;->mobileNetworkCode:Ljava/lang/String;

    .line 18755
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18759
    const v0, -0x6e1031b8

    return v0
.end method
