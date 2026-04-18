.class public Lorg/drinkless/tdlib/TdApi$UpdatePaidMediaPurchased;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdatePaidMediaPurchased"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5bef19a5


# instance fields
.field public payload:Ljava/lang/String;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34768
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34769
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 34758
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34759
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdatePaidMediaPurchased;->userId:J

    .line 34760
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdatePaidMediaPurchased;->payload:Ljava/lang/String;

    .line 34761
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34765
    const v0, -0x5bef19a5

    return v0
.end method
