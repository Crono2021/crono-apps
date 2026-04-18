.class public Lorg/drinkless/tdlib/TdApi$GetLogTagVerbosityLevel;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetLogTagVerbosityLevel"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$LogVerbosityLevel;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x38af2d83


# instance fields
.field public tag:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13056
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13057
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 13047
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13048
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetLogTagVerbosityLevel;->tag:Ljava/lang/String;

    .line 13049
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13053
    const v0, 0x38af2d83

    return v0
.end method
