.class public Lorg/drinkless/tdlib/TdApi$UpdateGroupCall;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateGroupCall"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x30324e00


# instance fields
.field public groupCall:Lorg/drinkless/tdlib/TdApi$GroupCall;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21836
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21837
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$GroupCall;)V
    .locals 0
    .param p1, "groupCall"    # Lorg/drinkless/tdlib/TdApi$GroupCall;

    .line 21827
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21828
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateGroupCall;->groupCall:Lorg/drinkless/tdlib/TdApi$GroupCall;

    .line 21829
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21833
    const v0, 0x30324e00

    return v0
.end method
