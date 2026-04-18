.class public Lorg/drinkless/tdlib/TdApi$ChatEventAutomaticTranslationToggled;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventAutomaticTranslationToggled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xb927656


# instance fields
.field public hasAutomaticTranslation:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9780
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9781
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 9771
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9772
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventAutomaticTranslationToggled;->hasAutomaticTranslation:Z

    .line 9773
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9777
    const v0, 0xb927656

    return v0
.end method
