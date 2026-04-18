.class public Lorg/drinkless/tdlib/TdApi$GroupCallParticipantVideoInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GroupCallParticipantVideoInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xda1e75


# instance fields
.field public endpointId:Ljava/lang/String;

.field public isPaused:Z

.field public sourceGroups:[Lorg/drinkless/tdlib/TdApi$GroupCallVideoSourceGroup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37755
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$GroupCallVideoSourceGroup;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "groupCallVideoSourceGroupArr"    # [Lorg/drinkless/tdlib/TdApi$GroupCallVideoSourceGroup;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "z8"    # Z

    .line 37743
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37744
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipantVideoInfo;->sourceGroups:[Lorg/drinkless/tdlib/TdApi$GroupCallVideoSourceGroup;

    .line 37745
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipantVideoInfo;->endpointId:Ljava/lang/String;

    .line 37746
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipantVideoInfo;->isPaused:Z

    .line 37747
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37751
    const v0, -0xda1e75

    return v0
.end method
