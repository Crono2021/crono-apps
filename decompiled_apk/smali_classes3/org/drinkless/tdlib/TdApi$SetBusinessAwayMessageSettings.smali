.class public Lorg/drinkless/tdlib/TdApi$SetBusinessAwayMessageSettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBusinessAwayMessageSettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4974486c


# instance fields
.field public awayMessageSettings:Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19482
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19483
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageSettings;)V
    .locals 0
    .param p1, "businessAwayMessageSettings"    # Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageSettings;

    .line 19473
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19474
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessAwayMessageSettings;->awayMessageSettings:Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageSettings;

    .line 19475
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19479
    const v0, 0x4974486c    # 1000582.75f

    return v0
.end method
