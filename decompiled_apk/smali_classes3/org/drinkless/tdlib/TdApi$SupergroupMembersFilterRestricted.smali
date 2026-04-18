.class public Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilterRestricted;
.super Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SupergroupMembersFilterRestricted"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4207afe2


# instance fields
.field public query:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20688
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;-><init>()V

    .line 20689
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 20679
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;-><init>()V

    .line 20680
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilterRestricted;->query:Ljava/lang/String;

    .line 20681
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20685
    const v0, -0x4207afe2

    return v0
.end method
