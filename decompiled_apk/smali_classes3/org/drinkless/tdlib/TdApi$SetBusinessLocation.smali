.class public Lorg/drinkless/tdlib/TdApi$SetBusinessLocation;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBusinessLocation"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x148bf8eb


# instance fields
.field public location:Lorg/drinkless/tdlib/TdApi$BusinessLocation;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19536
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19537
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BusinessLocation;)V
    .locals 0
    .param p1, "businessLocation"    # Lorg/drinkless/tdlib/TdApi$BusinessLocation;

    .line 19527
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19528
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessLocation;->location:Lorg/drinkless/tdlib/TdApi$BusinessLocation;

    .line 19529
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19533
    const v0, -0x148bf8eb

    return v0
.end method
