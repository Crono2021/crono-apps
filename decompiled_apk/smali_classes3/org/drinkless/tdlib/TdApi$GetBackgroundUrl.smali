.class public Lorg/drinkless/tdlib/TdApi$GetBackgroundUrl;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBackgroundUrl"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$HttpUrl;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2bbc6fd2


# instance fields
.field public name:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$BackgroundType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25664
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25665
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$BackgroundType;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "backgroundType"    # Lorg/drinkless/tdlib/TdApi$BackgroundType;

    .line 25654
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25655
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetBackgroundUrl;->name:Ljava/lang/String;

    .line 25656
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetBackgroundUrl;->type:Lorg/drinkless/tdlib/TdApi$BackgroundType;

    .line 25657
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25661
    const v0, 0x2bbc6fd2

    return v0
.end method
