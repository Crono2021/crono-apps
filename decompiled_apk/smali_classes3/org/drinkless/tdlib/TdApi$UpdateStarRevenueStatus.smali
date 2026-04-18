.class public Lorg/drinkless/tdlib/TdApi$UpdateStarRevenueStatus;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateStarRevenueStatus"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x10b40335


# instance fields
.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public status:Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34908
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34909
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "starRevenueStatus"    # Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;

    .line 34898
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34899
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateStarRevenueStatus;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 34900
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateStarRevenueStatus;->status:Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;

    .line 34901
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34905
    const v0, -0x10b40335

    return v0
.end method
