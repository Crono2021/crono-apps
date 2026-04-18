.class public Lorg/drinkless/tdlib/TdApi$GetStatisticalGraph;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStatisticalGraph"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StatisticalGraph;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x419f8d9b


# instance fields
.field public chatId:J

.field public f8018x:J

.field public token:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37490
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37491
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;J)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "j9"    # J

    .line 37479
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37480
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetStatisticalGraph;->chatId:J

    .line 37481
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetStatisticalGraph;->token:Ljava/lang/String;

    .line 37482
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$GetStatisticalGraph;->f8018x:J

    .line 37483
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37487
    const v0, 0x419f8d9b

    return v0
.end method
