.class public Lorg/drinkless/tdlib/TdApi$GiftSettings;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2ba9880


# instance fields
.field public acceptedGiftTypes:Lorg/drinkless/tdlib/TdApi$AcceptedGiftTypes;

.field public showGiftButton:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26944
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26945
    return-void
.end method

.method public constructor <init>(ZLorg/drinkless/tdlib/TdApi$AcceptedGiftTypes;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "acceptedGiftTypes"    # Lorg/drinkless/tdlib/TdApi$AcceptedGiftTypes;

    .line 26934
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26935
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$GiftSettings;->showGiftButton:Z

    .line 26936
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GiftSettings;->acceptedGiftTypes:Lorg/drinkless/tdlib/TdApi$AcceptedGiftTypes;

    .line 26937
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26941
    const v0, 0x2ba9880

    return v0
.end method
