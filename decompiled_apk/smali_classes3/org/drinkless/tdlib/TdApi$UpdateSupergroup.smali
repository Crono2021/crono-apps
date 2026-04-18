.class public Lorg/drinkless/tdlib/TdApi$UpdateSupergroup;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateSupergroup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4939adc


# instance fields
.field public supergroup:Lorg/drinkless/tdlib/TdApi$Supergroup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22178
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22179
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Supergroup;)V
    .locals 0
    .param p1, "supergroup"    # Lorg/drinkless/tdlib/TdApi$Supergroup;

    .line 22169
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22170
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateSupergroup;->supergroup:Lorg/drinkless/tdlib/TdApi$Supergroup;

    .line 22171
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22175
    const v0, -0x4939adc

    return v0
.end method
