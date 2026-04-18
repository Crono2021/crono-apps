.class public Lorg/drinkless/tdlib/TdApi$CallServer;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallServer"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6f37df97


# instance fields
.field public id:J

.field public ipAddress:Ljava/lang/String;

.field public ipv6Address:Ljava/lang/String;

.field public port:I

.field public type:Lorg/drinkless/tdlib/TdApi$CallServerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46708
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46709
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;ILorg/drinkless/tdlib/TdApi$CallServerType;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "i9"    # I
    .param p6, "callServerType"    # Lorg/drinkless/tdlib/TdApi$CallServerType;

    .line 46695
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46696
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CallServer;->id:J

    .line 46697
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CallServer;->ipAddress:Ljava/lang/String;

    .line 46698
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$CallServer;->ipv6Address:Ljava/lang/String;

    .line 46699
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$CallServer;->port:I

    .line 46700
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$CallServer;->type:Lorg/drinkless/tdlib/TdApi$CallServerType;

    .line 46701
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46705
    const v0, 0x6f37df97

    return v0
.end method
