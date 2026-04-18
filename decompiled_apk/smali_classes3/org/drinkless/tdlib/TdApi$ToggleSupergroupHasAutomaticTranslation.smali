.class public Lorg/drinkless/tdlib/TdApi$ToggleSupergroupHasAutomaticTranslation;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSupergroupHasAutomaticTranslation"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xb06c518


# instance fields
.field public hasAutomaticTranslation:Z

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33428
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33429
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33418
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33419
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupHasAutomaticTranslation;->supergroupId:J

    .line 33420
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupHasAutomaticTranslation;->hasAutomaticTranslation:Z

    .line 33421
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33425
    const v0, -0xb06c518

    return v0
.end method
